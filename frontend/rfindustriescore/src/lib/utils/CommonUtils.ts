export function isNull(data: any) {
  return data == null || data == undefined;
}

export function isNotNull(data: any) {
  return !isNull(data);
}
