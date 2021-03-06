package agenda;

import java.util.*;

public class TestHashMap {
	public static void main(String[] args) {
		String cod_banco;
		Map bancos = new HashMap(); // DECLARAMOS EL HASHMAP
		
		System.out.println("Esta vacio el HashMap? ( Tiene que salir true) ");
		System.out.println(bancos.isEmpty());
		
		bancos.put("1827", "BBVA"); // A�ADIR KEY Y VALUE AL HASHMAP
		bancos.put("0049", "Santander"); // A�ADIR KEY Y VALUE AL HASHMAP
		bancos.put("2038", "Bankia"); // A�ADIR KEY Y VALUE AL HASHMAP
		bancos.put("2100", "La Caixa"); // A�ADIR KEY Y VALUE AL HASHMAP
		
		System.out.println("Ahora hay datos en el HashMap ( Tiene que salir false )");
		System.out.println(bancos.isEmpty());
		
		System.out.println("Mostramos los " + bancos.size() + " que tenemos");
		
		Iterator it = bancos.keySet().iterator(); // CREAR ITERADOR PARA MOSTRARLO
		System.out.println(bancos.size());
		while (it.hasNext()) { // MANERA DE MOSTRAR
			cod_banco = (String) it.next();
			System.out.println(cod_banco + ": " + bancos.get(cod_banco));

		}
		System.out.println();
		System.out.println("A�adimos un dato mas");
		bancos.put("0000", "Penedes");
		
		System.out.println();
		bancos.forEach((k, v) -> System.out.println("Clave: " + k + "Valor: " + v));
		
		System.out.println();
		System.out.println("Buscamos el valor 0049");
		System.out.println(bancos.get("0049"));
		
		System.out.println();
		System.out.println("Borramos el valor 1827");
		bancos.remove("1827");
		
		System.out.println();
		bancos.forEach((k, v) -> System.out.println("Clave: " + k + "Valor: " + v));
		
		System.out.println();
		System.out.println("Devuelve true si encuentra la clave 2100");
		System.out.println(bancos.containsKey("2100"));
		
		System.out.println();
		System.out.println("Devuelve true si encuentra el valor La Caixa");
		System.out.println(bancos.containsValue("La Caixa"));
		
		System.out.println();
		System.out.println("Borramos los datos del HashMap");
		System.out.println("Tiene datos el HashMap?");
		System.out.println(bancos.isEmpty());

	}
}
