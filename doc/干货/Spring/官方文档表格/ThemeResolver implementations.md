# ThemeResolver implementations

Class|Description
--|--
FixedThemeResolver|Selects a fixed theme, set by using the defaultThemeName property.
SessionThemeResolver|The theme is maintained in the user’s HTTP session. It needs to be set only once for each session but is not persisted between sessions.
CookieThemeResolver|The selected theme is stored in a cookie on the client.
