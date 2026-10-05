public class Main {
    public static void main(String[] args) {
        LegacyFirewall legacyFirewall = new LegacyFirewall();
        SecurityLog securityLog = new FirewallAdapter(legacyFirewall);

        securityLog.logEvent("Unauthorized login attempt detected.");
        securityLog.setSeverity(5);
    }
}