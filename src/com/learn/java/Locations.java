package com.learn.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Locations implements Map<Integer, Location> {
	/**
	 * Create a Location class with locationID and description as fields Every
	 * location should have at least 1 exit + "QUIT" exit
	 * 
	 * The main locations are: 
	 * - You are sitting in front of a computer learning Java 
	 * - You are standing at the end of a road before a small brick building 
	 * - You are at the top of a hill 
	 * - You are inside a building, a well house for a small spring 
	 * - You are in a valley beside a stream 
	 * - You are in the forest
	 * 
	 * You start the game at the location 1 => "You are standing at the end of a
	 * road before a small brick building" The player can exit the game if he reach
	 * the location 0 => "You are sitting in front of a computer learning Java"
	 *
	 * Try to read from the Locations.txt and the Exits.txt files
	 * - Exits.txt contains the exits of each location
	 * - Locations.txt contains the locations of the game
	 * Output the result on the console
	 */

	// Fields
	private static Map<Integer, Location> locations = new HashMap<>();

	public static void main(String[] args) throws IOException {
		/**
		 * Read from Location.txt file with FileReader
		 */
		System.out.println("/*--- Locations.txt ---*/");
		try (Scanner scanner = new Scanner(new FileReader("Locations.txt"))) {
			// Use ":" as a Delimiter
			scanner.useDelimiter(":");
			// Returns true if there is another line in the input of this scanner
			while (scanner.hasNextLine()) {
				// Get the locationId
				int locationId = scanner.nextInt();
				// Skip the Delimiter ":"
				scanner.skip(scanner.delimiter());
				// Get the locationDescription
				String locationDescription = scanner.nextLine();

				// Output the result
				System.out.println("Location: " + locationId + " => " + locationDescription);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * Read from Exits.txt file with BufferedReader
		 */
		System.out.println("/*--- Exits.txt ---*/");
		try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("Exits.txt")))) {
			// Use ":" as a Delimiter
			scanner.useDelimiter(":");
			// Returns true if there is another line in the input of this scanner
			while (scanner.hasNextLine()) {
				// Get the locationId
				int locationId = scanner.nextInt();
				// Skip the Delimiter ":"
				scanner.skip(scanner.delimiter());
				// Get the location exits
				String exit = scanner.nextLine();
				
				// Output the result
				System.out.println("Location: " + locationId + ": " + exit);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Methods
	@Override
	public int size() {
		return locations.size();
	}

	@Override
	public boolean isEmpty() {
		return locations.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return locations.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return locations.containsValue(value);
	}

	@Override
	public Location get(Object key) {
		return locations.get(key);
	}

	@Override
	public Location put(Integer key, Location value) {
		return locations.put(key, value);
	}

	@Override
	public Location remove(Object key) {
		return locations.remove(key);
	}

	@Override
	public void putAll(Map<? extends Integer, ? extends Location> m) {
		// TODO Auto-generated method stub
	}

	@Override
	public void clear() {
		locations.clear();
	}

	@Override
	public Set<Integer> keySet() {
		return locations.keySet();
	}

	@Override
	public Collection<Location> values() {
		return locations.values();
	}

	@Override
	public Set<Entry<Integer, Location>> entrySet() {
		return locations.entrySet();
	}

}
