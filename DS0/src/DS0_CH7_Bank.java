import java.util.ArrayList;

public class DS0_CH7_Bank {
    private String bankName;
    private ArrayList<DS0_CH7_Account> accounts;

    public DS0_CH7_Bank(String name)
    {
        bankName=name;
        accounts = new ArrayList<>();
    }

    public boolean openAccount(long accountNumber, String customerName, double startingBalance)
    {
        if (startingBalance<=0){
            return false;
        }

        for (int x=0; x<accounts.size(); x++) {
            if (accounts.get(x).getAccountNumber()==accountNumber){
                return false;
            }
        }
        accounts.add(new DS0_CH7_Account(accountNumber, customerName,startingBalance));
        return true;
    }


    public double closeAccount(long accountNumber)
    {
        for (int x=0; x<accounts.size(); x++) {
            if (accounts.get(x).getAccountNumber()==accountNumber){
                double bal = accounts.get(x).getBalance();
                accounts.remove(x);
                return bal;
            }
        }
        return -1;
    }

    public void setName(String bankName)
    {
        this.bankName=bankName;
    }
    public String getName()
    {
        return bankName;
    }
    public DS0_CH7_Account getAccount(long accountNumber)
    {
        for (int x=0; x<accounts.size(); x++) {
            if (accounts.get(x).getAccountNumber()==accountNumber) {
            return accounts.get(x);
            }
        }
        return null;
    }

    public ArrayList<DS0_CH7_Account> getAccounts()
    {
        return accounts;
    }

}