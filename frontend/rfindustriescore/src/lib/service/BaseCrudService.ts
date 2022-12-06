import { RequestBrowser } from "../beans/core/RequestBrowser";
import { ResponseBrowser } from "../beans/core/ResponseBrowser";
import { ResponseMethod } from "../beans/core/ResponseMethod";
import { BaseDTO } from "../dto/BaseDTO";
import {
  deleteRequest,
  getRequest,
  postRequest,
  putRequest,
} from "../utils/HttpUtils";
import { BaseService } from "./BaseService";

export abstract class BaseCrudService<DTO extends BaseDTO> extends BaseService {
  pathRead: string = "/read";
  pathInsert: string = "/insert";
  pathUpdate: string = "/update";
  pathDelete: string = "/delete";
  pathBrowser: string = "/browser";

  pathGoInsert: string = "/go-insert";
  pathGoUpdate: string = "/go-update";

  constructor(
    path: string,
    pathRead?: string,
    pathInsert?: string,
    pathUpdate?: string,
    pathDelete?: string,
    pathGoInsert?: string,
    pathGoUpdate?: string,
    pathBrowser?: string
  ) {
    super(path);
    this.pathRead = pathRead || this.pathRead;
    this.pathInsert = pathInsert || this.pathInsert;
    this.pathUpdate = pathUpdate || this.pathUpdate;
    this.pathDelete = pathDelete || this.pathDelete;
    this.pathGoInsert = pathGoInsert || this.pathGoInsert;
    this.pathGoUpdate = pathGoUpdate || this.pathGoUpdate;
    this.pathBrowser = pathBrowser || this.pathBrowser;
  }

  async browser(
    requestBroser: RequestBrowser
  ): Promise<ResponseMethod<ResponseBrowser<DTO>>> {
    return await postRequest(
      this.resolveUrl() + this.pathBrowser,
      requestBroser
    );
  }

  async read(pk: any): Promise<ResponseMethod<DTO>> {
    return await getRequest(
      this.resolveUrl() + this.pathRead + "?pk=" + pk,
      undefined
    );
  }

  async goUpdate(pk: any): Promise<ResponseMethod<DTO>> {
    return await getRequest(
      this.resolveUrl() + this.pathGoUpdate + "?pk=" + pk,
      undefined
    );
  }

  async goInsert(): Promise<ResponseMethod<DTO>> {
    return await getRequest(this.resolveUrl() + this.pathGoInsert, undefined);
  }

  async delete(dto: DTO): Promise<ResponseMethod<Boolean>> {
    return await deleteRequest(this.resolveUrl() + this.pathDelete, dto);
  }

  async insert(dto: DTO): Promise<ResponseMethod<DTO>> {
    return await postRequest(this.resolveUrl() + this.pathInsert, dto);
  }

  async update(dto: DTO): Promise<ResponseMethod<DTO>> {
    return await putRequest(this.resolveUrl() + this.pathUpdate, dto);
  }
}
