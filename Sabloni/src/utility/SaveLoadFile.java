package utility;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SaveLoadFile {

	public static <T> T readObjectFromFile(String filepath) {
		File f=new File(filepath);
		if (f.exists()) {
			System.out.println("Imam odakle citati ");
		}
		try (FileInputStream fileIn = new FileInputStream(filepath);
				ObjectInputStream objectIn = new ObjectInputStream(fileIn);) {

			T obj = (T) objectIn.readObject();

			System.out.println("Objekat ucitan iz fajla");
			objectIn.close();
			return obj;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static <T> void writeObjectToFile(T serObj, String filepath) {
		File f=new File(filepath);
		if (f.exists()) {
			System.out.println("Imamgde pisati");
		}
		try (FileOutputStream fileOut = new FileOutputStream(filepath);
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);) {

			objectOut.writeObject(serObj);
			objectOut.close();
			System.out.println(serObj.toString() + "sniman u fajl ");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static <T> void writeObjectsToFile( List<T> objects,String filepath) {
		File f=new File(filepath);
		if (f.exists()) {
			System.out.println("Imamgde pisati");
		}
		if (objects != null) {
			try (FileOutputStream os = new FileOutputStream(filepath);
					ObjectOutputStream oos = new ObjectOutputStream(os);) {

				for (T object : objects) {
					oos.writeObject(object);
				}
				oos.flush();

			} catch (FileNotFoundException e) {
				System.out.println("Nema fajla za upis podataka  ");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static <T> List<T> readObjectsFromFile(String filename) {
		
		File f=new File(filename);
		if (f.exists()) {
			System.out.println("Imam odakle da ucitam ");
		}
		List<T> objects = new ArrayList<>();
		File file = new File(filename);

		try (FileInputStream is = new FileInputStream(filename); ObjectInputStream ois = new ObjectInputStream(is);) {

			while (true) {
				try {
					T object = (T) ois.readObject();
					objects.add((T) object);
					System.out.println("citam " + object.toString());
				} catch (EOFException ex) {
					break;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return objects;
		} catch (FileNotFoundException e1) {
			System.out.println("Nema fajla o zaposlenima");
			e1.printStackTrace();
		} catch (IOException e1) {
			System.out.println("Neuspesno ucitavanje");
		}

		return null;
	}

	public static <T, U> Map<T, U> readMapObjectFromFile(String filename) {
		
		File f=new File(filename);
		if (f.exists()) {
			System.out.println("Imam odakle da ucitam ");
		}
		Map<T, U> objects = new HashMap<>();
		File file = new File(filename);

		try (FileInputStream is = new FileInputStream(filename); ObjectInputStream ois = new ObjectInputStream(is);) {

			while (true) {
				try {
					HashMap object = (HashMap<T, U>) ois.readObject();

				} catch (EOFException ex) {
					break;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return objects;
		} catch (FileNotFoundException e1) {
			System.out.println("Nema fajla o zaposlenima");
			e1.printStackTrace();
		} catch (IOException e1) {
			System.out.println("Neuspesno ucitavanje");
		}

		return null;
	}

	public static <T, U> void writeMapToFile( Map<T, U> objects,String filepath) {
		
		File f=new File(filepath);
		if (f.exists()) {
			System.out.println("Imam gde da upisujem ");
		}
		
		try (FileOutputStream os = new FileOutputStream(filepath);
				ObjectOutputStream oos = new ObjectOutputStream(os);) {

			oos.writeObject(objects);

			oos.flush();

		} catch (FileNotFoundException e) {
			System.out.println("Nema fajla za upis podataka  ");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
