import { CvModule } from './cv.module';

describe('CvModule', () => {
  let cvModule: CvModule;

  beforeEach(() => {
    cvModule = new CvModule();
  });

  it('should create an instance', () => {
    expect(cvModule).toBeTruthy();
  });
});
