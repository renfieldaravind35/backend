{
  "nbformat": 4,
  "nbformat_minor": 0,
  "metadata": {
    "colab": {
      "provenance": []
    },
    "kernelspec": {
      "name": "python3",
      "display_name": "Python 3"
    },
    "language_info": {
      "name": "python"
    }
  },
  "cells": [
    {
      "cell_type": "code",
      "source": [
        "\n",
        "package se.firmacarboo.letsgo.controller;\n",
        "\n",
        "import lombok.AllArgsConstructor;\n",
        "import org.springframework.http.HttpStatus;\n",
        "import org.springframework.http.ResponseEntity;\n",
        "import org.springframework.web.bind.annotation.*;\n",
        "import se.firmacarboo.letsgo.entity.Image;\n",
        "import se.firmacarboo.letsgo.service.ImageServiceImpl;\n",
        "\n",
        "import java.util.List;\n",
        "import java.util.Optional;\n",
        "@CrossOrigin(origins = \"http://localhost:3000\", maxAge = 3600)\n",
        "@RestController\n",
        "@RequestMapping(\"api/v1/images\")\n",
        "@AllArgsConstructor\n",
        "public class ImageController {\n",
        "    ImageServiceImpl imageServiceImpl;\n",
        "\n",
        "    @GetMapping\n",
        "    public List<Image> getAllImages(){\n",
        "        return imageServiceImpl.getAllImages();\n",
        "    }\n",
        "\n",
        "    @GetMapping(\"/{imageId}\")\n",
        "    public Optional<Image> getImage(@PathVariable String imageId){\n",
        "        return imageServiceImpl.getImageById(imageId);\n",
        "    }\n",
        "\n",
        "    @PostMapping(\"/register-image\")\n",
        "    public ResponseEntity registerNewImage(@RequestBody Image image){\n",
        "        return new ResponseEntity(imageServiceImpl.registerNewImage(image), HttpStatus.OK);\n",
        "    }\n",
        "\n",
        "    @PutMapping(\"/update-image\")\n",
        "    public ResponseEntity<String> updateImage(@RequestBody Image image){\n",
        "        String result = imageServiceImpl.updateImage(image);\n",
        "\n",
        "        if(!result.equals(\"Image successfully updated.\")){\n",
        "            return ResponseEntity.badRequest().body(result);\n",
        "        }\n",
        "        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(result);\n",
        "    }\n",
        "\n",
        "    @DeleteMapping(\"/delete-image/{id}\")\n",
        "    public ResponseEntity<String> deleteImage(@PathVariable String id){\n",
        "        Boolean deleteSuccessful = imageServiceImpl.deleteImageById(id);\n",
        "\n",
        "        if(!deleteSuccessful){\n",
        "            return ResponseEntity.notFound().build();\n",
        "        }\n",
        "\n",
        "        return ResponseEntity.ok().build();\n",
        "    }\n",
        "}"
      ],
      "metadata": {
        "id": "3EU2dhV4MWtE"
      },
      "execution_count": null,
      "outputs": []
    }
  ]
}