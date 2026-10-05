public class FirewallAdapter implements SecurityLog {
    private LegacyFirewall firewall;

    public FirewallAdapter(LegacyFirewall firewall) {
        this.firewall = firewall;
    }

    @Override
    public void logEvent(String message) {
        firewall.recordActivity(message);
    }

    @Override
    public void setSeverity(int level) {
        firewall.setAlertLevel(level);
    }
}