import java.math.BigDecimal;

// Definición de un record
public record ProductRecord(
        Long id,
        String name,
        BigDecimal price,
        String category
) {
    // El compilador genera automáticamente:
// - Constructor canónico
// - Métodos de acceso (id(), name(), etc.)
// - equals(), hashCode(), toString()
// Se pueden agregar métodos adicionales
    public boolean isPremiumProduct() {
        return price.compareTo(
                new BigDecimal("100")
        ) >= 0;
    }
    // También constructores compactos
    public ProductRecord {
// Validaciones o transformaciones
        if (name == null) {
            name = "Sin nombre";
        }
    }
}
