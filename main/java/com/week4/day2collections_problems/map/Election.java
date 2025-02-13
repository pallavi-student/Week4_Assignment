package com.week4.day2collections_problems.map;

import java.util.*;

class VotingSystem<T> {
    private Map<T, Integer> voteMap = new HashMap<>(); // Stores votes (Candidate -> Votes)
    private Map<T, Integer> voteOrderMap = new LinkedHashMap<>(); // Maintains order of voting
    private TreeMap<T, Integer> sortedVoteMap = new TreeMap<>(); // Stores sorted results

    // Cast a vote for a candidate
    public void castVote(T candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(candidate, voteOrderMap.getOrDefault(candidate, 0) + 1);
    }

    // Display votes in order of voting (LinkedHashMap)
    public void displayVotesInOrder() {
        System.out.println("\nVotes in Order of Voting:");
        for (Map.Entry<T, Integer> entry : voteOrderMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Display results sorted by candidate names (TreeMap)
    public void displaySortedResults() {
        sortedVoteMap.putAll(voteMap); // Sort the HashMap by candidate name
        System.out.println("\nSorted Election Results:");
        for (Map.Entry<T, Integer> entry : sortedVoteMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Display the winner
    public void displayWinner() {
        T winner = null;
        int maxVotes = 0;

        for (Map.Entry<T, Integer> entry : voteMap.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        System.out.println("\nWinner: " + winner + " with " + maxVotes + " votes!");
    }
}

public class Election {
    public static void main(String[] args) {
        VotingSystem<String> votingSystem = new VotingSystem<>();

        // Casting votes
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");

        // Display votes in order of voting
        votingSystem.displayVotesInOrder();

        // Display sorted election results
        votingSystem.displaySortedResults();

        // Display the winner
        votingSystem.displayWinner();
    }
}
