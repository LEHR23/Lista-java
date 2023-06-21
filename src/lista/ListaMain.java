package lista;

public class ListaMain {

    public static void main(String[] args) {
        
        List lista = new List();
        lista.append(5);
        lista.append(6);
        lista.insert(1, 0);
        lista.show();
        lista.pop(0);
        lista.show();
    }
}
