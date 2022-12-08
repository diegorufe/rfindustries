import { CssVarProps } from "../features/CssVarProps";
import { isNotNull } from "./CommonUtils";

export function defaultCssVarsProps(): CssVarProps {
  return {
    appBackColor: "white",
    appSecondaryBackColor: "white",
    appFontColor: "black",
  } as CssVarProps;
}

export function cssVars(
  cssVarPropos: CssVarProps = defaultCssVarsProps(),
  otherProps?: { [key: string]: string }
): string {
  let builder = `<style> `;
  builder = builder + " :root { ";
  let anyCssVarprops: any = cssVarPropos;

  if (isNotNull(otherProps)) {
    for (const key in otherProps) {
      anyCssVarprops[key] = otherProps[key];
    }
  }

  for (const key in cssVarPropos) {
    builder = builder + " --" + key + ":" + anyCssVarprops[key] + "; ";
  }

  builder = builder + " } ";

  builder =
    builder +
    `
        body, html, #app, #App {
            margin: 0;
            padding: 0;
            height: 100%;
            width: 100%;
            float: left;
            color:  var(--appFontColor, black);
        } 
    `;

  builder = builder + " </style>";

  return builder;
}

export function cssVarsAppComponent(): string {
  return `
    <style>
        .AppComponent {
            margin: 0;
            padding: 0;
            height: 100%;
            width: 100%;
            float: left;
            background-color: var(--appBackColor, white);
            color:  var(--appFontColor, black);
        }
    </style>
    `;
}
