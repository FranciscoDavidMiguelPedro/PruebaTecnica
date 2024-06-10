package paqt.frank.practica.user.v1.constant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.UUID;

/**
 * Clase utilitaria para generar folios únicos. Los folios se generan utilizando
 * un timestamp y un UUID.
 */
public final class Folio {



	private static final Integer UUID_LENGTH = 18;
    private static final Integer TIMESTAMP_LENGTH = 13;

    private Folio() {
        // Constructor privado para prevenir la instanciación
    }

    /**
     * Método para generar un folio.
     * Este método genera un folio único utilizando un timestamp y un UUID.
     * El UUID se genera sin guiones y se convierte a mayúsculas.
     * El timestamp se genera con el formato especificado en Constantes.FORMATO_FECHA.
     * 
     * @return El folio generado, que es una concatenación del timestamp y el UUID.
     */
    public static String generarFolio() {
        String uuid = UUID.randomUUID().toString().substring(0, UUID_LENGTH).replace("-", "");
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern(Constantes.FORMATO_FECHA)).substring(0, TIMESTAMP_LENGTH);

        return timeStamp + uuid.toUpperCase(new Locale(Constantes.FORMATO_LOCALE_MX));
    }
}
