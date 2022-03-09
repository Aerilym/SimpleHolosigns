# Simple Holosigns

Create holographic signs using invisible armor stands with simple commands.

## Why does this exist?

1. Copy pasting the long command and editing it in Minecraft's chat was annoying.
2. While there are plenty of plugins which already do similar or the same thing, I found many of them were bundled in with other unrelated functionality or stopped working with Minecraft updates. I just wanted something that world work always, with minimal user effort. If you want more advanced implementations check them out [here](#Other-Implementations).
3. It was easy to make and I enjoy doing this.

## Usage

Note: Arguments surrounded with < > are required (eg. \<color\>) and [ ] are optional (eg. *[range]*)

- **/holosign** - Get commands and information. Alias: /hs /hsign /hologram /holo
- **/holosign create** \<color\> *[f1] [f2] [f3] [f4]* \<text\> - Creates a holosign at your location with the text provided, color, and formatting (optional: bold, italic etc.)
- **/holosign delete** *[range]* - Deletes holosigns (armor stands) in a radius around you (default 2)");

## How it works

This plugin simply utilises the minecraft summon and kill commands to create holographic signs.

### Creating Signs

The signs created are simply armor stands with special NBT properties which make them invisible, indestructible, and non-interactive. The basic Minecraft command in use is the `/summon` command:

`/summon <entity> [<pos>] [<nbt>]` - [Minecraft Wiki](https://minecraft.fandom.com/wiki/Commands/summon)

The fully filled in command is:

```
/summon armor_stand ~ ~ ~ {Invisible:1b,Invulnerable:1b,PersistenceRequired:1b,NoGravity:1b,Marker:1b,CustomName:'{"text":"<text here>","color":"<color here>","bold":"<state>","italic":"<state>","obfuscated":"<state>","strikethrough":"<state>"}',CustomNameVisible:1b}
```

The variables passed through from the plugin when using the command are:

- \<text here\> : The user provided text to be used on the sign.
- \<color here\> : The user provided color to be used on teh sign.
- \<state\> : For each formatting type, the state corresponding to the user's given arguments are used. A false state (eg. not having the argument `bold` in the plugin command) removed the whole `"bold":"<state>",` section of the command send to the server.

### Deleting Signs

As the signs created are simply invulnerable armor stands, they must be removed using the Minecraft `/kill` command. The delete command used by the plugin works by calling this `/kill` command:

`/kill [<targets>]` - [Minecraft Wiki](https://minecraft.fandom.com/wiki/Commands/kill)

The fully filled in command is:

```
/minecraft:kill @e[type=armor_stand,distance=..<range>]
```

The only user variable passed from the plugin to the server is the optional variable `<range>`.

The command `/minecraft:kill` is used instead of `/kill` as this ensures the "plugin" command used is the vanilla Minecraft command `/kill`.

## Other Implementations

*I have no affiliation with these developers and I'm sure there are plenty more who have made similar plugins, these are just the plugins I'm aware of*

- [Holograms](https://www.spigotmc.org/resources/holograms.4924/) - "A small and efficient Hologram managing plugin"
- [DeluxeHub 3](https://www.spigotmc.org/resources/deluxehub-3-professional-hub-management.49425/) - "Your all-in-one, essential and professional hub core solution."
- [GHolo](https://www.spigotmc.org/resources/gholo-the-new-modern-holo-plugin-1-9-x-1-18-x.70913/) - "Create Holos with modern Technology, great Performance and Animations!"
