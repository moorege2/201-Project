package com.musicplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // ===== Get all users =====
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ===== Get user by username =====
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // ===== Get user by ID =====
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    // ===== Register a new user =====
    public String registerUser(User newUser) {
        if (newUser.getUsername() == null || newUser.getUsername().isBlank()) {
            return "Username is required.";
        }
        if (newUser.getFriends() == null) {
         newUser.setFriends(new ArrayList<>());
        }
        if (newUser.getEmail() == null || newUser.getEmail().isBlank()) {
            return "Email is required.";
        }
        if (newUser.getPassword() == null || newUser.getPassword().isBlank()) {
            return "Password is required.";
        }
        if (userRepository.findByUsername(newUser.getUsername()) != null) {
            return "Username already taken.";
        }
        if (userRepository.findByEmail(newUser.getEmail()) != null) {
            return "Email already in use.";
        }

        // NOTE: In production, hash the password here (e.g. BCrypt) before saving
        userRepository.save(newUser);
        return "Registration successful.";
    }

    // ===== Login =====
    public String loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) return "User not found.";

        // NOTE: In production, use BCrypt.matches() here instead of plain equals
        if (!user.getPassword().equals(password)) return "Incorrect password.";

        return "Login successful";

    }

    // ===== Update user profile =====
    public String updateUser(String username, User updatedUser) {
        User existing = userRepository.findByUsername(username);
        if (existing == null) return "User not found.";

        existing.setFirstName(updatedUser.getFirstName());
        existing.setLastName(updatedUser.getLastName());
        existing.setEmail(updatedUser.getEmail());

        // Only update password if a new one is provided
        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isBlank()) {
            // NOTE: Hash before saving in production
            existing.setPassword(updatedUser.getPassword());
        }

        userRepository.save(existing);
        return "Profile updated.";
    }

    // ===== Delete a user =====
    public String deleteUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) return "User not found.";
        userRepository.deleteById(user.getId());
        return "User " + username + " deleted.";
    }

    public String updateUsername(String oldUsername, String newUsername) {
    if (userRepository.findByUsername(newUsername) != null) return "Username already taken.";
    User user = userRepository.findByUsername(oldUsername);
    if (user == null) return "User not found.";
    user.setUsername(newUsername);
    userRepository.save(user);
    return "Username updated.";
}

public List<String> getFriends(String username) {
    User user = userRepository.findByUsername(username);
    if (user == null) return new ArrayList<>();
    return user.getFriends() != null ? user.getFriends() : new ArrayList<>();
}

public String addFriend(String username, String friendUsername) {
    User user = userRepository.findByUsername(username);
    User friend = userRepository.findByUsername(friendUsername);

    if (user == null) return "User not found.";
    if (friend == null) return "Friend not found.";

    if (user.getFriends() == null) user.setFriends(new ArrayList<>());
    if (friend.getFriends() == null) friend.setFriends(new ArrayList<>());

    if (user.getFriends().contains(friendUsername)) return "Already friends.";

    user.getFriends().add(friendUsername);
    friend.getFriends().add(username); 

    userRepository.save(user);
    userRepository.save(friend); 

    return "Friend added successfully.";
}

// ===== Search users by username =====
public List<User> searchUsers(String query) {
    return userRepository.findByUsernameContainingIgnoreCase(query);
}

// ===== Follow / send request =====
public String followUser(String senderUsername, String targetUsername) {
    User sender = userRepository.findByUsername(senderUsername);
    User target = userRepository.findByUsername(targetUsername);

    if (sender == null) return "User not found.";
    if (target == null) return "Target user not found.";

    // Add these null guards
    if (sender.getFollowing() == null) sender.setFollowing(new ArrayList<>());
    if (target.getFollowers() == null) target.setFollowers(new ArrayList<>());
    if (target.getPendingRequests() == null) target.setPendingRequests(new ArrayList<>());

    if (sender.getFollowing().contains(targetUsername)) return "Already following.";

    if (target.isPrivate()) {
        // Add to pending requests instead
        if (!target.getPendingRequests().contains(senderUsername)) {
            target.getPendingRequests().add(senderUsername);
            userRepository.save(target);
        }
        return "Follow request sent.";
    } else {
        sender.getFollowing().add(targetUsername);
        target.getFollowers().add(senderUsername);
        userRepository.save(sender);
        userRepository.save(target);
        return "Now following.";
    }
}

// ===== Unfollow =====
public String unfollowUser(String senderUsername, String targetUsername) {
    User sender = userRepository.findByUsername(senderUsername);
    User target = userRepository.findByUsername(targetUsername);

    if (sender.getFollowing() == null) sender.setFollowing(new ArrayList<>());
if (target.getFollowers() == null) target.setFollowers(new ArrayList<>());
    if (sender == null || target == null) return "User not found.";

    sender.getFollowing().remove(targetUsername);
    target.getFollowers().remove(senderUsername);
    userRepository.save(sender);
    userRepository.save(target);
    return "Unfollowed.";
}

// ===== Approve follow request =====
public String approveRequest(String currentUser, String requester) {
    User user = userRepository.findByUsername(currentUser);
    User req = userRepository.findByUsername(requester);

    if (user == null || req == null) return "User not found.";
    if (user.getPendingRequests() == null) user.setPendingRequests(new ArrayList<>());
if (user.getFollowers() == null) user.setFollowers(new ArrayList<>());
if (req.getFollowing() == null) req.setFollowing(new ArrayList<>());

    user.getPendingRequests().remove(requester);
    user.getFollowers().add(requester);
    req.getFollowing().add(currentUser);
    userRepository.save(user);
    userRepository.save(req);
    return "Approved.";
}

// ===== Reject follow request =====
public String rejectRequest(String currentUser, String requester) {
    User user = userRepository.findByUsername(currentUser);
    if (user == null) return "User not found.";

    if (user.getPendingRequests() == null) user.setPendingRequests(new ArrayList<>());
    user.getPendingRequests().remove(requester);
    userRepository.save(user);
    return "Rejected.";
}

// ===== Update privacy =====
public String updatePrivacy(String username, boolean isPrivate) {
    User user = userRepository.findByUsername(username);
    if (user == null) return "User not found.";
    user.setPrivate(isPrivate);
    userRepository.save(user);
    return "Privacy updated.";
}
}