export abstract class BaseService {
  path: string;

  constructor(path: string) {
    this.path = path;
  }

  abstract resolveUrl(): string;
}
