import { mount } from "@vue/test-utils";
import { StyleComponent } from "../../../index";

test("mount component", async () => {
  expect(StyleComponent).toBeTruthy();

  const wrapper = mount(StyleComponent);

  expect(wrapper.text()).toContain("root");

  expect(wrapper.html()).toMatchSnapshot()
});
