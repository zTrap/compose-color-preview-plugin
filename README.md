[![Plugin version](https://img.shields.io/jetbrains/plugin/v/21298-compose-colors-preview)](https://plugins.jetbrains.com/plugin/21298-compose-colors-preview)

# ![Preview](./src/main/resources/META-INF/pluginIcon.svg) Compose color preview plugin for JetBrains IDE family

This plugin draws colors on editor's gutter. You can modify colors by clicking on icons

It works with `androidx.compose.ui.graphics.Color` from 
[Jetpack Compose](https://developer.android.com/jetpack/compose) or 
[Compose Multiplatform](https://www.jetbrains.com/ru-ru/lp/compose-mpp)

## Features

   * Show preview in `Color` creation places ✔️
     * ULong constructor ✔️
     * Long function "constructor" ✔️
     * Int function "constructor" ✔️
     * Int x3 function "constructor" ✔️
     * Float x3 function "constructor" ✔️
     * Float x3 with color scheme function "constructor" ✔️
     * Float x4 function "constructor" ✔️
     * Float x4 with color scheme function "constructor" ✔️
   * Show palette by clicking on preview to change color ✔️
      * Change color with saving original numeral system  ✔️
   * Show preview in places fields with type `Color` usage ❌

![Preview](./.github/preview.png)

## Installation

Install it from the Jetbrains plugin repository within your IDE (**recommended**):

- <kbd>File</kbd> > <kbd>Settings</kbd> > <kbd>Plugins</kbd> > <kbd>Browse repositories...</kbd> > <kbd>Search 'Color preview'</kbd> > <kbd>Category 'Editor'</kbd>

You can also download the JAR package from the [Jetbrains plugin repository](https://plugins.jetbrains.com/plugin/21298-compose-colors-preview) or 
from [GitHub Releases](https://github.com/zTrap/compose-color-preview-plugin/releases) and add it manually to your plugins:

- <kbd>File</kbd> > <kbd>Settings</kbd> > <kbd>Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

## Contribution

Contributions are welcome. Please check [CONTRIBUTING.md](./CONTRIBUTING.md) for more information.

Besides source code contributions, feel free to open bug reports or just suggest new features [here](https://github.com/zTrap/compose-color-preview-plugin/issues).

## License

- [The Apache License Version 2.0](https://www.apache.org/licenses/LICENSE-2.0.txt)

```
Copyright 2023 Peter Gulko (zTrap)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```