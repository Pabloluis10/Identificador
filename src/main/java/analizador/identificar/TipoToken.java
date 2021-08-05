package analizador.identificar;

/**
 *
 * @author pabloluis
 */
public enum TipoToken {
    
    ID("Identificador: "), ENTERO("Entero: "), DECIMAL("Decimal: "), SIMBOLO("Simbolo: "), ERROR("Error: ");
    
    private String tipo;
    
    private TipoToken(String tipo){
        this.tipo = tipo;
    }
    
    public String getTipo(){
        return tipo;
    }
}
