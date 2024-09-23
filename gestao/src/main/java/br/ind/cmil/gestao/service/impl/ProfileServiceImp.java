package br.ind.cmil.gestao.service.impl;

import br.ind.cmil.gestao.domain.user.RoleUser;
import br.ind.cmil.gestao.domain.user.TypeProfile;
import br.ind.cmil.gestao.dto.ProfileDTO;
import br.ind.cmil.gestao.dto.mapper.ProfileMapper;
import br.ind.cmil.gestao.exception.RecordNotFoundException;
import br.ind.cmil.gestao.respositories.ProfileRepository;
import br.ind.cmil.gestao.service.ProfileService;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrativo
 */
@Service
@Transactional
public class ProfileServiceImp implements ProfileService {
    
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ProfileMapper profileMapper;
    
    @Override
    public ProfileDTO save(ProfileDTO dto) {
        if (dto.id() == null) {
            validingProfile(dto);
            return profileMapper.toDTO(profileRepository.save(profileMapper.toEntity(dto)));
        }
        return update(dto);
    }

    @Transactional(readOnly = false)
    public ProfileDTO update(ProfileDTO p) {
        return profileRepository.findById(p.id())
                .map(recordFound -> {
                    recordFound.setType(TypeProfile.convertProfileValue(p.type()));
                    return profileMapper.toDTO(profileRepository.save(recordFound));
                }).orElseThrow(() -> new RecordNotFoundException(String.valueOf(p.id()), "Este id não consta no bd! "));
    }
    
    @Override
    public ProfileDTO findById(String id) {
        return profileRepository.findById(id).map(profileMapper::toDTO).orElseThrow(() -> new RecordNotFoundException(String.valueOf(id), "Not Found! "));
    }

    @Transactional(readOnly = true)
    @Override
    public Set<ProfileDTO> profiles() {
        return profileRepository.searchAll().stream().map(profileMapper::toDTO).collect(Collectors.toSet());
    }
    
    @Override
    public void delete(String id) {
        Optional<RoleUser> profile = profileRepository.findById(id);
        profileRepository.delete(profile.get());
    }
    
    protected void validingProfile(ProfileDTO p) {
        Optional<RoleUser> profile = profileRepository.findByType(TypeProfile.convertProfileValue(p.type()));
        if (profile.isPresent() && !Objects.equals(profile.get().getId(), p.id())) {
            throw new DataIntegrityViolationException("Profile exixte!");
        }
        
    }
    
}
