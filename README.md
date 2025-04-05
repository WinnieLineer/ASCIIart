# ASCII Art Generator

A Java application that converts images into ASCII art.

## Features

- Supports various image formats
- Customizable output width
- Customizable character sets
- Automatic image resizing
- Grayscale conversion

## Usage

```bash
java -jar ASCIIart.jar <image_path> [char_set] [width]
```

### Parameters

- `image_path`: Path to the image file to convert (required)
- `char_set`: Character set for conversion (optional, default is " .▪◆●■█")
- `width`: Output width (optional, default is 80)

### Examples

```bash
# Using default settings
java -jar ASCIIart.jar image.jpg

# Custom character set and width
java -jar ASCIIart.jar image.jpg "@%#*+=-:. " 100
```

## Development Environment

- Java 8 or higher
- Maven 3.6 or higher

## Build

```bash
mvn clean package
```

## License

MIT License
