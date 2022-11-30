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
        "package se.firmacarboo.letsgo.entity;\n",
        "\n",
        "import lombok.*;\n",
        "import org.springframework.data.mongodb.core.index.Indexed;\n",
        "import org.springframework.data.mongodb.core.mapping.Document;\n",
        "\n",
        "@NoArgsConstructor\n",
        "@AllArgsConstructor\n",
        "@Getter\n",
        "@Setter\n",
        "@Document(collection=\"Images\")\n",
        "public class Image extends BaseEntity{\n",
        "\n",
        "    //Makes image URL unique, which will prevent entering duplicates\n",
        "    @Indexed(unique = true)\n",
        "    private String imageUrl;\n",
        "    private String imageAltText;\n",
        "    private UsageType usageType;\n",
        "}"
      ],
      "metadata": {
        "id": "qHOH-G3GNRtj"
      },
      "execution_count": null,
      "outputs": []
    }
  ]
}