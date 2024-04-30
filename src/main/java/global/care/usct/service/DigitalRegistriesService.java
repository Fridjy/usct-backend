package global.care.usct.service;

import global.care.usct.controller.dto.digital.registries.PackageDto;
import java.util.List;

public interface DigitalRegistriesService {

  List<PackageDto> getAll();
}
