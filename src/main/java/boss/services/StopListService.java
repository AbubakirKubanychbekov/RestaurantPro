package boss.services;

import boss.dto.SimpleResponse;
import boss.dto.request.StopListRequest;
import boss.dto.response.StopListResponse;

import java.util.List;

public interface StopListService {
   List<StopListResponse> getAllStopLists();

    SimpleResponse saveSl(StopListRequest saveSl, Long menuId);

    StopListResponse getSlById(Long id);

    SimpleResponse deleteSl(Long id);

    SimpleResponse updateSl(Long id, StopListRequest stopListRequest);
}
