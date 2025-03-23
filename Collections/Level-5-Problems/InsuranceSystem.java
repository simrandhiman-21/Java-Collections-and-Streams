import java.util.*;

class Policy {
    String policyNumber, holderName, coverageType;
    Date expiryDate;
    double premium;

    Policy(String num, String name, String type, Date date, double premium) {
        this.policyNumber = num;
        this.holderName = name;
        this.coverageType = type;
        this.expiryDate = date;
        this.premium = premium;
    }

    public String toString() {
        return policyNumber + " | " + holderName + " | " + coverageType + " | " + expiryDate + " | " + premium;
    }
}

class InsuranceSystem {
    private Map<String, Policy> policyMap = new HashMap<>();
    private LinkedHashMap<String, Policy> orderedPolicies = new LinkedHashMap<>();
    private TreeMap<Date, Policy> sortedByExpiry = new TreeMap<>();

    void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicies.put(policy.policyNumber, policy);
        sortedByExpiry.put(policy.expiryDate, policy);
    }

    Policy getPolicy(String number) {
        return policyMap.get(number);
    }

    List<Policy> getExpiringSoon() {
        Date now = new Date();
        Date threshold = new Date(now.getTime() + (30L * 24 * 60 * 60 * 1000)); // 30 days ahead
        return new ArrayList<>(sortedByExpiry.subMap(now, threshold).values());
    }

    List<Policy> getPoliciesByHolder(String name) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.holderName.equalsIgnoreCase(name)) result.add(policy);
        }
        return result;
    }

    void removeExpired() {
        Date now = new Date();
        sortedByExpiry.headMap(now, true).clear();
        policyMap.values().removeIf(p -> p.expiryDate.before(now));
        orderedPolicies.values().removeIf(p -> p.expiryDate.before(now));
    }

    void displayPolicies() {
        orderedPolicies.values().forEach(System.out::println);
    }

    public static void main(String[] args) {
        InsuranceSystem system = new InsuranceSystem();
        system.addPolicy(new Policy("P123", "Alice", "Health", new Date(2025 - 1900, 6, 15), 500.0));
        system.addPolicy(new Policy("P124", "Bob", "Auto", new Date(2024 - 1900, 3, 25), 300.0));
        system.displayPolicies();
        System.out.println("Expiring Soon: " + system.getExpiringSoon());
        System.out.println("Policies for Alice: " + system.getPoliciesByHolder("Alice"));
        system.removeExpired();
        system.displayPolicies();
    }
}
