package org.unibl.program.Service;

import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Category;
import org.unibl.program.Entity.Contact;
import org.unibl.program.Entity.Requests.CategoryRequest;
import org.unibl.program.Entity.Requests.ContactRequest;
import org.unibl.program.Repository.CategoryRepository;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> getAll();
    Category createCategory();
}
