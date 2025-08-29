# StandaloneEvent
### A powerful event system for Minecraft Server Plugin or Applications.
- --------------------
## Usage:
### For Minecraft Server Plugins
1. Include StandaloneEvent-API into your plugin dependency.
2. Mark "StandaloneEvent" as a depend-plugin.
3. Install Standalone Plugin in the server.

### For Applications
1. Include StandaloneEvent-Common into your app dependency.
2. At the beginning of your application, call ```ApiProvider.inject()```
3. Shade StandaloneEvent into your application.