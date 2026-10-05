import java.util.Arrays;
import java.util.List;

public class CommandCenterFacade {
    private NetworkTrafficController network;
    private UserAccessManager users;
    private EncryptionService encryption;

    private List<String> compromisedUsers = Arrays.asList(
        "admin_temp",
        "guest_user_1",
        "service_acct"
    );

    public CommandCenterFacade(
        NetworkTrafficController network,
        UserAccessManager users,
        EncryptionService encryption
    ) {
        this.network = network;
        this.users = users;
        this.encryption = encryption;
    }

    public void initiateEmergencyLockdown() {
        System.out.println("=== EMERGENCY LOCKDOWN ===");

        network.blockPort(8080);
        network.blockPort(443);
        users.lockUserAccounts(compromisedUsers);
        encryption.encryptDatabase("Customer_Records");

        System.out.println("Emergency lockdown complete.");
    }

    public void liftEmergencyLockdown() {
        System.out.println("=== LIFTING EMERGENCY LOCKDOWN ===");

        network.unblockPort(8080);
        network.unblockPort(443);
        users.unlockUserAccounts(compromisedUsers);
        encryption.decryptDatabase("Customer_Records");

        System.out.println("Emergency lockdown lifted.");
    }

    public void enableMaintenanceMode() {
        System.out.println("=== MAINTENANCE MODE ===");

        network.divertTraffic();
        users.grantAdminAccess("maintenance_admin");
        encryption.verifyIntegrity();

        System.out.println("Maintenance mode enabled.");
    }
}