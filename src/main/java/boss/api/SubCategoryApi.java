package boss.api;

import boss.dto.SimpleResponse;
import boss.dto.request.SubCategoryRequest;
import boss.dto.response.SubCategoryResponse;
import boss.services.SubCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sub_category")
@Tag(name = "SubCategoryApi")
public class SubCategoryApi {

    private final SubCategoryService subCategoryService;

    @GetMapping
    @Operation(summary = "Get All Sub Categories")
    List<SubCategoryResponse>getAllSubCats(){
        return subCategoryService.getAllSubCats();
    }

    @PostMapping("/{catId}/{menuId}")
    SimpleResponse savSubC(@PathVariable Long catId,
                           @PathVariable Long menuId,
                           @RequestBody SubCategoryRequest saveSabC){
        return subCategoryService.saveSubC(catId,menuId,saveSabC);
    }
}
