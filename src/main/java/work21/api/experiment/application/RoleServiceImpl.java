package work21.api.experiment.application;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work21.api.experiment.data.RoleRepository;
import work21.api.experiment.domain.Role;

import java.util.Collection;
import java.util.Optional;

@Service
public class RoleServiceImpl implements IService<Role> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Collection<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role saveOrUpdate(Role role) {
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            roleRepository.deleteById(id);
            jsonObject.put("message", "Role deleted successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

}
