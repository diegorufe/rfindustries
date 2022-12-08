import { mount } from "@vue/test-utils";
import { TestComponent } from "../../index";

test("mount component", async () => {
  expect(TestComponent).toBeTruthy();

  const wrapper = mount(TestComponent, {
    props: {
      msg: "TEST",
    },
  });

  expect(wrapper.text()).toContain("TEST");
  expect(wrapper.html()).toMatchInlineSnapshot('"<p>TEST</p>"');
});
