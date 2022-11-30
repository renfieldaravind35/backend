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
        "package se.firmacarboo.letsgo.service;\n",
        "\n",
        "import se.firmacarboo.letsgo.entity.Image;\n",
        "\n",
        "import java.util.List;\n",
        "import java.util.Optional;\n",
        "\n",
        "public interface ImageService {\n",
        "\n",
        "    Boolean existsByImageUrl(String imageUrl);\n",
        "    List<Image> getAllImages();\n",
        "    Optional<Image> getImageById(String id);\n",
        "    Optional<Image> getImageByImageUrl(String imageUrl);\n",
        "    String registerNewImage(Image image);\n",
        "    String updateImage(Image image);\n",
        "    Boolean deleteImageById(String id);\n",
        "}"
      ],
      "metadata": {
        "id": "vuj6KJboWKSp"
      },
      "execution_count": null,
      "outputs": []
    }
  ]
}