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
        "import lombok.Getter;\n",
        "import lombok.Setter;\n",
        "import org.springframework.data.annotation.Id;\n",
        "\n",
        "@Getter\n",
        "@Setter\n",
        "public abstract class BaseEntity {\n",
        "\n",
        "    @Id\n",
        "    private String id;\n",
        "    private String name;\n",
        "}"
      ],
      "metadata": {
        "id": "IoO8Xp1BND9y"
      },
      "execution_count": null,
      "outputs": []
    }
  ]
}