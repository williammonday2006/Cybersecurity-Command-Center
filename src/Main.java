import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LegacyFirewall legacyFirewall = new LegacyFirewall();
        SecurityLog securityLog = new FirewallAdapter(legacyFirewall);

        NetworkTrafficController network = new NetworkTrafficController();
        UserAccessManager users = new UserAccessManager();
        EncryptionService encryption = new EncryptionService();

        CommandCenterFacade commandCenter = new CommandCenterFacade(
            network,
            users,
            encryption
        );

        System.out.println("=== CYBERSECURITY COMMAND CENTER ===");

        System.out.print("Enter security event message: ");
        String message = scanner.nextLine();

        System.out.print("Enter severity level: ");
        int severity = scanner.nextInt();
        scanner.nextLine();

        securityLog.logEvent(message);
        securityLog.setSeverity(severity);

        System.out.println();
        System.out.println("Choose a security mode:");
        System.out.println("1. Lockdown");
        System.out.println("2. Lift Lockdown");
        System.out.println("3. Maintenance");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                commandCenter.initiateEmergencyLockdown();
                break;
            case 2:
                commandCenter.liftEmergencyLockdown();
                break;
            case 3:
                commandCenter.enableMaintenanceMode();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        scanner.close();
    }
}