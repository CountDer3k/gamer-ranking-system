package com.d3labs.gamerrankingsystem.database.Models._Base;

import java.util.Base64;

/**
 * A base class for model that contain an image.
 */
public class ImageContainingModelBase {

	private byte[] BaseImage;

	/**
	 * Instatiates an ImageContainingModelBase.
	 */
	public ImageContainingModelBase() {

	}

	/**
	 * Sets the base image as a byte array
	 * 
	 * @param image A byte array represntation of an image.
	 */
	public void setBaseImage(byte[] image) {
		this.BaseImage = image;
	}

	/**
	 * Gets the base image as a byte array.
	 * 
	 * @return A byte array representation fo an image.
	 */
	public byte[] getBaseImage() {
		return this.BaseImage;
	}

	/**
	 * Converts the byte array of the image (the BLOB) into a base64 encoded string
	 * 
	 * @return A base64 encoded string representation of the image.
	 */
	public String getImageAsBase64() {
		if (this.BaseImage != null) {

			String imageString = Base64.getEncoder().encodeToString(this.BaseImage);

			return imageString;
		}

		return null;
	}
}