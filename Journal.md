# Phase 1

The Adapter lets the dashboard use SecurityLog without knowing how LegacyFirewall works. This follows the Principle of Least Knowledge because the dashboard only needs to know about the interface.

# Phase 2

I used a list to keep track of the users and manually remembered the ports. With thousands of ports and users, this would become difficult to manage and easy to mess up.