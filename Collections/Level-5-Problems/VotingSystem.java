import java.util.*;

class VotingSystem {
    private Map<String, Integer> votes = new HashMap<>();
    private LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();
    private TreeMap<String, Integer> sortedResults = new TreeMap<>();

    void vote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, votes.get(candidate));
        sortedResults.put(candidate, votes.get(candidate));
    }

    void displayResults() {
        System.out.println("Votes: " + votes);
        System.out.println("Vote Order: " + voteOrder);
        System.out.println("Sorted Results: " + sortedResults);
    }

    public static void main(String[] args) {
        VotingSystem voting = new VotingSystem();
        voting.vote("Alice");
        voting.vote("Bob");
        voting.vote("Alice");
        voting.displayResults();
    }
}
