// This is a generated file. Not intended for manual editing.
package org.elixir_lang.psi.impl;

import com.ericsson.otp.erlang.OtpErlangObject;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.elixir_lang.psi.Digits;
import org.elixir_lang.psi.ElixirOctalDigits;
import org.elixir_lang.psi.ElixirOctalWholeNumber;
import org.elixir_lang.psi.ElixirVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ElixirOctalWholeNumberImpl extends ASTWrapperPsiElement implements ElixirOctalWholeNumber {

  public ElixirOctalWholeNumberImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ElixirVisitor visitor) {
    visitor.visitOctalWholeNumber(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ElixirVisitor) accept((ElixirVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ElixirOctalDigits> getOctalDigitsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ElixirOctalDigits.class);
  }

  public int base() {
    return ElixirPsiImplUtil.base(this);
  }

  @NotNull
  public List<Digits> digitsList() {
    return ElixirPsiImplUtil.digitsList(this);
  }

  @NotNull
  public OtpErlangObject quote() {
    return ElixirPsiImplUtil.quote(this);
  }

}
