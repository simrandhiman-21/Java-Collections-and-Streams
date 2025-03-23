import java.util.*;

class BankingSystem {
    private Map<Integer, Double> accounts = new HashMap<>();
    private TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
    private Queue<int[]> withdrawals = new LinkedList<>();

    void createAccount(int acc, double balance) {
        accounts.putIfAbsent(acc, balance);
        sortedAccounts.put(balance, acc);
    }

    void deposit(int acc, double amount) {
        if (accounts.containsKey(acc)) {
            sortedAccounts.remove(accounts.get(acc));
            accounts.put(acc, accounts.get(acc) + amount);
            sortedAccounts.put(accounts.get(acc), acc);
        }
    }

    void requestWithdrawal(int acc, double amount) {
        if (accounts.containsKey(acc)) withdrawals.add(new int[]{acc, (int) amount});
    }

    void processWithdrawals() {
        while (!withdrawals.isEmpty()) {
            int[] req = withdrawals.poll();
            if (accounts.get(req[0]) >= req[1]) deposit(req[0], -req[1]);
        }
    }

    void displayAccounts() {
        System.out.println("Accounts: " + accounts);
        System.out.println("Sorted Accounts: " + sortedAccounts);
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.createAccount(1001, 5000);
        bank.createAccount(1002, 3000);
        bank.deposit(1001, 1500);
        bank.requestWithdrawal(1001, 2000);
        bank.processWithdrawals();
        bank.displayAccounts();
    }
}
