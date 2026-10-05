# Phase 1

The Adapter lets the dashboard use SecurityLog without knowing how LegacyFirewall works. This follows the Principle of Least Knowledge because the dashboard only needs to know about the interface.

# Phase 2

I used a list to keep track of the users and manually remembered the ports. With thousands of ports and users, this would become difficult to manage and easy to mess up.

# Phase 3

The Facade makes Main much simpler by letting it call one method instead of many subsystem methods. If the network controller changed, only the Facade would need to be updated.