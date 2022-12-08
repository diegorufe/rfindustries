import { CssVarProps } from "../features/CssVarProps";
import { isNotNull } from "./CommonUtils";



export function defaultCssVarsProps(): CssVarProps {
    return {
        appBackColor: "white",
        appSecondaryBackColor: "white",
        appFontColor: "black",
    } as CssVarProps
}

export function cssVars(cssVarPropos: CssVarProps = defaultCssVarsProps(), otherProps?: { [key: string]: string }): string {
    let builder = " :root { ";
    let anyCssVarprops: any = cssVarPropos;

    if (isNotNull(otherProps)) {
        for (const key in otherProps) {
            anyCssVarprops[key] = otherProps[key];
        }
    }

    for (const key in cssVarPropos) {
        builder = builder + " --" + key + ":" + anyCssVarprops[key] + "; "
    }

    builder = builder + " }";

    return builder;
}
