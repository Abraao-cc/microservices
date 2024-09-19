
package br.ind.cmil.gestao.converts;

import br.ind.cmil.gestao.domain.user.TypeProfile;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.stream.Stream;

/**
 *
 * @author Administrativo
 */
@Converter(autoApply = true)
public class ProfileConvert implements AttributeConverter <TypeProfile, String> {

    @Override
    public String convertToDatabaseColumn(TypeProfile attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public TypeProfile convertToEntityAttribute(String dbData) {
         if (dbData == null) {
            return null;
        }
        return Stream.of(TypeProfile.values())
                .filter((tp) -> tp.getValue().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
    
}
