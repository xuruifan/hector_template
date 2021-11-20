import hls._

object synthStencil2d extends App {
  TclGen(new stencil, "test_run_dir/synth_stencil2d/", "stencil")
}

object synthSpmvCSR extends App {
  TclGen(new spmv, "test_run_dir/synth_spmv_csr/", "spmv")
}

object synthStencil3d extends App {
  TclGen(new stencil3d, "test_run_dir/synth_stencil3d/", "stencil3d")
}

object synthGemmNcubed extends App {
  TclGen(new gemm, "test_run_dir/synth_gemm_ncubed/", "gemm")
}

object synthAelossPull extends App {
  TclGen(new aeloss_pull, "test_run_dir/synth_aeloss_pull/", "aeloss_pull")
}

object synthAelossPush extends App {
  TclGen(new aeloss_push, "test_run_dir/synth_aeloss_push/", "aeloss_push")
}
