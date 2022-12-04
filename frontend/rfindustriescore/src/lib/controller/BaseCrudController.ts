import { BaseDTO } from "../dto/BaseDTO";
import { BaseCrudService } from "../service/BaseCrudService";
import {
  initReactivityObject,
  setReactiveData,
} from "../utils/ReactivityUtils";
import { BaseController } from "./BaseController";

export abstract class BaseCrudController<
  SERVICE extends BaseCrudService<DTO>,
  DTO extends BaseDTO
> extends BaseController {
  service?: SERVICE;
  element?: DTO;
  data: DTO[] = [];

  constructor() {
    super();
    this.init();
  }

  abstract instanceService(): void;

  init(): void {
    this.initReactivityElement();
  }

  initReactivityElement() {
    this.element = initReactivityObject({} as DTO);
  }

  setElement(dto?: DTO) {
    setReactiveData(this.element, dto);
  }
}
