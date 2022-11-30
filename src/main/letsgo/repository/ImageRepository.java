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
        "package se.firmacarboo.letsgo.repository;\n",
        "\n",
        "import org.springframework.data.mongodb.repository.MongoRepository;\n",
        "import se.firmacarboo.letsgo.entity.Image;\n",
        "\n",
        "import java.util.Optional;\n",
        "\n",
        "public interface ImageRepository extends MongoRepository<Image, String> {\n",
        "\n",
        "    Boolean existsByImageUrl(String imageUrl);\n",
        "    Optional<Image> findImageByImageUrl(String imageUrl);\n",
        "}"
      ],
      "metadata": {
        "id": "G9PRMcN_V0t5"
      },
      "execution_count": null,
      "outputs": []
    }
  ]
}