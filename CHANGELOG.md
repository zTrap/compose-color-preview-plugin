# Change Log

## [0.0.9] - 04-07-2024

### Added

- Added chessboard drawing behind icons for highlighting transparent colors

### Fixed

- Missed leading zeros when alpha is lower than 6% now renders properly

## [0.0.8] - 29-04-2024

### Added

- Preview for simple constant fields is now renders also in code completion popup

### Fixed

- Unspecified color is now excluded from rendering
- Switched to using the kotlin IDE's built-in stdlib instead of the explicit one

## [0.0.7] - 23-04-2024

### Fixed
- Fixed icons duplication when creator function have named parameters
- Fixed rendering of `lerp`, `compositeOver` and `convert` functions result
- Fixed preview rendering for proxy-properties with getter

## [0.0.6] - 21-04-2024

### Added

- Small optimization for psi-tree processing

### Fixed

- Fixed `lerp` preview with non-default argument order
- Removed overlap of supported IDE versions between plugin versions

## [0.0.5] - 20-04-2024

### Added

- Preview icons are now divided to 3 groups:
  - Editable color
  - Constants usage
  - Result of modifier functions
- Each group can now be enabled/disabled in the settings (Settings/Preferences | Editor | General | Gutter Icons)

### Fixed

- File analysis time has been optimized by merging 3 psi-tree processors into 1
- Fixed icons alignment

## [0.0.4] - 15-04-2024

### Added

- Preview is now renders for new functions:
    - compositeOver
    - convert
    - copy
    - lerp
    - Color.hsl
    - Color.hsv

### Fixed

- Preview is now renders correctly for constants from compiled dependencies
- Preview is now renders for more places
- Proxy field preview is now limited to val only

## [0.0.3] - 10-04-2024

### Added

- Added display of colored icon for using fields (chaining proxy fields is also supported)

### Fixed

- The property list now displays correctly when two or more colors are displayed on the same line

## [0.0.2] - 05-04-2024

### Added

- The plugin is divided into 3 branches, which support 3 different ide versions

## [0.0.1] - 21-03-2023

- Initial release.