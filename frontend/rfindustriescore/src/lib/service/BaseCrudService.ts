import { BaseDTO } from "../dto/BaseDTO";
import { BaseService } from "./BaseService";

export abstract class BaseCrudService<DTO extends BaseDTO> extends BaseService {
  pathRead: string = "/read";
  pathInsert: string = "/insert";
  pathUpdate: string = "/update";
  pathDelete: string = "/delete";

  pathGoInsert: string = "/go-insert";
  pathGoUpdate: string = "/go-update";

  constructor(
    pathRead?: string,
    pathInsert?: string,
    pathUpdate?: string,
    pathDelete?: string,
    pathGoInsert?: string,
    pathGoUpdate?: string
  ) {
    super();
    this.pathRead = pathRead || this.pathRead;
    this.pathInsert = pathInsert || this.pathInsert;
    this.pathUpdate = pathUpdate || this.pathUpdate;
    this.pathDelete = pathDelete || this.pathDelete;
    this.pathGoInsert = pathGoInsert || this.pathGoInsert;
    this.pathGoUpdate = pathGoUpdate || this.pathGoUpdate;
  }

  abstract insert(dto: DTO): void;
}
