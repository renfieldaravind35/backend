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
        "import static org.junit.jupiter.api.Assertions.assertEquals;\n",
        "import static org.junit.jupiter.api.Assertions.assertTrue;\n",
        "import static org.mockito.Mockito.*;\n",
        "import java.util.Optional;\n",
        "\n",
        "import org.junit.jupiter.api.Test;\n",
        "import org.junit.jupiter.api.extension.ExtendWith;\n",
        "import org.springframework.beans.factory.annotation.Autowired;\n",
        "import org.springframework.boot.test.mock.mockito.MockBean;\n",
        "import org.springframework.test.context.ContextConfiguration;\n",
        "import org.springframework.test.context.junit.jupiter.SpringExtension;\n",
        "import se.firmacarboo.letsgo.entity.Image;\n",
        "import se.firmacarboo.letsgo.entity.UsageType;\n",
        "import se.firmacarboo.letsgo.repository.ImageRepository;\n",
        "\n",
        "@ContextConfiguration(classes = {ImageServiceImpl.class})\n",
        "@ExtendWith(SpringExtension.class)\n",
        "class ImageServiceImplTest {\n",
        "    @MockBean\n",
        "    private ImageRepository imageRepository;\n",
        "\n",
        "    @Autowired\n",
        "    private ImageServiceImpl imageServiceImpl;\n",
        "\n",
        "    @Test\n",
        "    void testRegisterNewImage_imageUrlOccupied_shouldProduceMessageOfFailure() {\n",
        "\n",
        "        // given\n",
        "        Image image = new Image();\n",
        "        image.setId(\"42\");\n",
        "        image.setImageAltText(\"Image Alt Text\");\n",
        "        image.setImageUrl(\"https://example.org/example\");\n",
        "        image.setName(\"Name\");\n",
        "        image.setUsageType(UsageType.BRUSHTEETH);\n",
        "\n",
        "        Image image1 = new Image();\n",
        "        image1.setId(\"42\");\n",
        "        image1.setImageAltText(\"Image Alt Text\");\n",
        "        image1.setImageUrl(\"https://example.org/example\");\n",
        "        image1.setName(\"Name\");\n",
        "        image1.setUsageType(UsageType.BRUSHTEETH);\n",
        "\n",
        "        Optional<Image> ofResult = Optional.of(image1);\n",
        "        String message = \"There is already an image with imageUrl: \" + image1.getImageUrl();\n",
        "\n",
        "        // a stub?\n",
        "        // when the mocked repository's insert method is called, then return image\n",
        "        when(this.imageRepository.insert((Image) any())).thenReturn(image);\n",
        "\n",
        "        // a stub?\n",
        "        // when the mocked repository's findImageByImageUrl(imageUrl) method is called,\n",
        "        // then return the Optional value of image1\n",
        "        when(this.imageRepository.findImageByImageUrl(any())).thenReturn(ofResult);\n",
        "\n",
        "        // a dummy?\n",
        "        Image image2 = new Image();\n",
        "        image2.setId(\"42\");\n",
        "        image2.setImageAltText(\"Image Alt Text\");\n",
        "        image2.setImageUrl(\"https://example.org/example\");\n",
        "        image2.setName(\"Name\");\n",
        "        image2.setUsageType(UsageType.BRUSHTEETH);\n",
        "\n",
        "        // then\n",
        "\n",
        "        // This is a mock?\n",
        "        assertEquals(message, this.imageServiceImpl.registerNewImage(image2));\n",
        "\n",
        "        // Mocks. They are only concerned with what method is called, and when.\n",
        "//        these methods check that the mocked repository is called by the given methods.\n",
        "        verify(this.imageRepository, times(0)).insert((Image) any());\n",
        "        verify(this.imageRepository, times(1)).findImageByImageUrl(any());\n",
        "\n",
        "//        Finally, this method asserts that imageServiceImpl truly only interacted\n",
        "//        with the mocked imageRepository = no connection to database.\n",
        "        assertTrue(this.imageServiceImpl.getAllImages().isEmpty());\n",
        "    }\n",
        "\n",
        "    @Test\n",
        "    void testRegisterNewImage_ValidImageUrl_shouldPass() {\n",
        "\n",
        "        // given\n",
        "        Image image = new Image();\n",
        "        image.setId(\"42\");\n",
        "        image.setImageAltText(\"Image Alt Text\");\n",
        "        image.setImageUrl(\"https://example.org/example\");\n",
        "        image.setName(\"Name\");\n",
        "        image.setUsageType(UsageType.BRUSHTEETH);\n",
        "\n",
        "        //stubs\n",
        "        when(this.imageRepository.insert((Image) any())).thenReturn(image);\n",
        "        when(this.imageRepository.findImageByImageUrl(any())).thenReturn(Optional.empty());\n",
        "\n",
        "        // dummy?\n",
        "        Image image1 = new Image();\n",
        "        image1.setId(\"42\");\n",
        "        image1.setImageAltText(\"Image Alt Text\");\n",
        "        image1.setImageUrl(\"https://example.org/example\");\n",
        "        image1.setName(\"Name\");\n",
        "        image1.setUsageType(UsageType.BRUSHTEETH);\n",
        "\n",
        "        assertEquals(\"Image has been successfully inserted.\", this.imageServiceImpl.registerNewImage(image1));\n",
        "\n",
        "        //mocks\n",
        "        verify(this.imageRepository).insert((Image) any());\n",
        "        verify(this.imageRepository).findImageByImageUrl(any());\n",
        "\n",
        "        assertTrue(this.imageServiceImpl.getAllImages().isEmpty());\n",
        "    }\n",
        "\n",
        "    @Test\n",
        "    void testRegisterNewImage3() {\n",
        "        Image image = new Image();\n",
        "        image.setId(\"42\");\n",
        "        image.setImageAltText(\"Image Alt Text\");\n",
        "        image.setImageUrl(\"https://example.org/example\");\n",
        "        image.setName(\"Name\");\n",
        "        image.setUsageType(UsageType.BRUSHTEETH);\n",
        "\n",
        "        Image image1 = new Image();\n",
        "        image1.setId(\"42\");\n",
        "        image1.setImageAltText(\"Image Alt Text\");\n",
        "        image1.setImageUrl(\"https://example.org/example\");\n",
        "        image1.setName(\"Name\");\n",
        "        image1.setUsageType(UsageType.BRUSHTEETH);\n",
        "        Optional<Image> ofResult = Optional.of(image1);\n",
        "        when(this.imageRepository.insert((Image) any())).thenReturn(image);\n",
        "        when(this.imageRepository.findImageByImageUrl(any())).thenReturn(ofResult);\n",
        "\n",
        "        Image image2 = new Image();\n",
        "        image2.setId(\"42\");\n",
        "        image2.setImageAltText(\"Image Alt Text\");\n",
        "        image2.setImageUrl(\"https://example.org/example\");\n",
        "        image2.setName(\"Name\");\n",
        "        image2.setUsageType(UsageType.BRUSHTEETH);\n",
        "        assertEquals(\"There is already an image with imageUrl: https://example.org/example\",\n",
        "                this.imageServiceImpl.registerNewImage(image2));\n",
        "        verify(this.imageRepository).findImageByImageUrl(any());\n",
        "\n",
        "        assertTrue(this.imageServiceImpl.getAllImages().isEmpty());\n",
        "    }\n",
        "\n",
        "    @Test\n",
        "    void testRegisterNewImage4() {\n",
        "        Image image = new Image();\n",
        "        image.setId(\"42\");\n",
        "        image.setImageAltText(\"Image Alt Text\");\n",
        "        image.setImageUrl(\"https://example.org/example\");\n",
        "        image.setName(\"Name\");\n",
        "        image.setUsageType(UsageType.BRUSHTEETH);\n",
        "        when(this.imageRepository.insert((Image) any())).thenReturn(image);\n",
        "        when(this.imageRepository.findImageByImageUrl(any())).thenReturn(Optional.empty());\n",
        "\n",
        "        Image image1 = new Image();\n",
        "        image1.setId(\"42\");\n",
        "        image1.setImageAltText(\"Image Alt Text\");\n",
        "        image1.setImageUrl(\"https://example.org/example\");\n",
        "        image1.setName(\"Name\");\n",
        "        image1.setUsageType(UsageType.BRUSHTEETH);\n",
        "        assertEquals(\"Image has been successfully inserted.\", this.imageServiceImpl.registerNewImage(image1));\n",
        "        verify(this.imageRepository).insert((Image) any());\n",
        "        verify(this.imageRepository).findImageByImageUrl(any());\n",
        "\n",
        "        assertTrue(this.imageServiceImpl.getAllImages().isEmpty());\n",
        "    }\n",
        "\n",
        "    @Test\n",
        "    void shouldUpdateImageSuccessfully() {\n",
        "        // TDD\n",
        "        // updateOne() returns a document holding:\n",
        "        // matchedCount: 1 (documents matching the query), modifiedCount: 1(documents modified), acknowledged: false (write concern)\n",
        "\n",
        "        // given\n",
        "        Image image = new Image();\n",
        "        image.setId(\"42\");\n",
        "        image.setImageAltText(\"Image Alt Text\");\n",
        "        image.setImageUrl(\"https://example.org/NEWurl\");\n",
        "        image.setName(\"Name\");\n",
        "        image.setUsageType(UsageType.BRUSHTEETH);\n",
        "\n",
        "        Image imageInDB = new Image();\n",
        "        imageInDB.setId(\"42\");\n",
        "        imageInDB.setImageAltText(\"Image Alt Text\");\n",
        "        imageInDB.setImageUrl(\"https://example.org/example\");\n",
        "        imageInDB.setName(\"Name\");\n",
        "        imageInDB.setUsageType(UsageType.BRUSHTEETH);\n",
        "\n",
        "        // This update shall succeed\n",
        "        when(this.imageRepository.findById(any())).thenReturn(Optional.of(imageInDB));\n",
        "        when(this.imageRepository.existsByImageUrl(any())).thenReturn(false);\n",
        "\n",
        "        // when\n",
        "        assertEquals(\"Image successfully updated.\", imageServiceImpl.updateImage(image));\n",
        "\n",
        "        // then\n",
        "        verify(this.imageRepository).findById(any());\n",
        "        verify(this.imageRepository).existsByImageUrl(any());\n",
        "\n",
        "        assertTrue(this.imageServiceImpl.getAllImages().isEmpty());\n",
        "\n",
        "        /*Todo on successful update\n",
        "         * get id from provided image CHECK!\n",
        "         * findImageById CHECK!\n",
        "         * compare fields to find which one was updated\n",
        "         * if imageUrl was updated, compare new imageUrl with existing ones in database CHECK!\n",
        "         * if Optional of findImageByUrl is empty, proceed CHECK!\n",
        "         * call imageRepository.save(image) CHECK!\n",
        "         * */\n",
        "\n",
        "        /*Todo on denied update due to URL\n",
        "         * get id from provided image\n",
        "         * findImageById\n",
        "         * compare fields to find which one was updated\n",
        "         * if imageUrl was updated, compare new imageUrl with existing ones in database\n",
        "         * if Optional of findImageByUrl is occupied, abort\n",
        "         * verify that imageRepository.save() was never called.\n",
        "         * */\n",
        "\n",
        "        /*Todo on denied update due to invalid id\n",
        "         * get id from provided image\n",
        "         * findImageById\n",
        "         * if null = findImageById, return error message\n",
        "         * assert that error message was thrown\n",
        "         * verify that imageRepository.save() was never called.\n",
        "         * */\n",
        "    }\n",
        "\n",
        "        /*\n",
        "            TODO Delete method tests\n",
        "             * Test for happy path CHECK!\n",
        "             * Test for failure\n",
        "             */\n",
        "\n",
        "    @Test\n",
        "    public void testDeleteImage_shouldPass() {\n",
        "        // Testing Happy path.\n",
        "\n",
        "        // given\n",
        "        Image imageInDB = new Image();\n",
        "        imageInDB.setId(\"42\");\n",
        "        imageInDB.setImageAltText(\"Image Alt Text\");\n",
        "        imageInDB.setImageUrl(\"https://example.org/example\");\n",
        "        imageInDB.setName(\"Name\");\n",
        "        imageInDB.setUsageType(UsageType.BRUSHTEETH);\n",
        "\n",
        "        when(this.imageRepository.findById(any())).thenReturn(Optional.of(imageInDB));\n",
        "\n",
        "        // when\n",
        "        imageServiceImpl.deleteImageById(any());\n",
        "\n",
        "        // then\n",
        "        verify(this.imageRepository).findById(any());\n",
        "        verify(this.imageRepository).deleteById(any());\n",
        "    }\n",
        "}\n",
        "\n",
        "\n",
        "\n",
        "\n",
        "\n",
        "\n",
        "\n",
        "\n",
        "\n",
        "\n",
        "\n",
        "\n"
      ],
      "metadata": {
        "id": "vXz_fROBGrw0"
      },
      "execution_count": null,
      "outputs": []
    }
  ]
}