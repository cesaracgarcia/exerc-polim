package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	
	public static void main(String[] args) throws ParseException {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("LANÇAMENTOS DE PRODUTOS ");
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c,u,i)?: ");
			char r = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			
			if (r=='i') {
				System.out.print("Custom fee: ");
				Double customFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customFee));
			}
			else
				if (r=='u')
				{
					System.out.print("Manufacture date (DD/MM/YYYY): ");
					Date manafacturedDate = df.parse(sc.next());
					list.add(new UsedProduct(name, price, manafacturedDate));
				}
				else
				{
					list.add(new Product(name, price));
				}
		}

		System.out.println("-----------------------------------------------------------------------");
		
		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}
		

		sc.close();
	}

}
