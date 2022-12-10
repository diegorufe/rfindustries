import { getAppContext, ModuleLoader } from "rfindustriescore";


export class TestModule implements ModuleLoader{
    loadI18n(): void {
        
    }
    loadLazyComponents(): void {
        const context = getAppContext();

        // TODO add components
    }
    
}